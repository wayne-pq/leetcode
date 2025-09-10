package cn.xxywithpq.责任链;

import java.util.HashMap;
import java.util.Map;

// 订单类
class Order {
    private String orderId;
    private double amount;
    private boolean isValid;
    private boolean isPaid;
    private boolean isShipped;
    private String status;

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = "Created";
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public boolean isValid() { return isValid; }
    public void setValid(boolean valid) { isValid = valid; }
    public boolean isPaid() { return isPaid; }
    public void setPaid(boolean paid) { isPaid = paid; }
    public boolean isShipped() { return isShipped; }
    public void setShipped(boolean shipped) { isShipped = shipped; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order #" + orderId + " [$" + amount + "]: " + status;
    }
}

// 抽象处理器：使用模板方法模式
abstract class OrderHandler {
    protected OrderHandler nextHandler;

    // 设置下一个处理器
    public OrderHandler setNext(OrderHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    // 模板方法：定义处理流程
    public final void process(Order order) {
        if (canHandle(order)) {
            handle(order);
            order.setStatus(getHandlerName() + " completed");
        }

        if (nextHandler != null) {
            nextHandler.process(order);
        }
    }

    // 抽象方法：具体处理逻辑（由子类实现）
    protected abstract void handle(Order order);

    // 判断是否能处理（可被子类覆盖）
    protected boolean canHandle(Order order) {
        return true;
    }

    // 处理器名称
    protected abstract String getHandlerName();
}

// 具体处理器：订单验证
class ValidationHandler extends OrderHandler {
    @Override
    protected void handle(Order order) {
        // 模拟验证逻辑
        System.out.println("✅ Validating order #" + order.getOrderId());
        order.setValid(true);
    }

    @Override
    protected String getHandlerName() {
        return "Validation";
    }
}

// 具体处理器：支付处理
class PaymentHandler extends OrderHandler {
    @Override
    protected void handle(Order order) {
        // 模拟支付逻辑
        System.out.println("💳 Processing payment for order #" + order.getOrderId());
        order.setPaid(true);
    }

    @Override
    protected boolean canHandle(Order order) {
        return order.isValid(); // 只有验证通过才能支付
    }

    @Override
    protected String getHandlerName() {
        return "Payment";
    }
}

// 具体处理器：发货处理
class ShippingHandler extends OrderHandler {
    @Override
    protected void handle(Order order) {
        // 模拟发货逻辑
        System.out.println("📦 Shipping order #" + order.getOrderId());
        order.setShipped(true);
    }

    @Override
    protected boolean canHandle(Order order) {
        return order.isPaid(); // 只有支付完成才能发货
    }

    @Override
    protected String getHandlerName() {
        return "Shipping";
    }
}

// 具体处理器：通知处理
class NotificationHandler extends OrderHandler {
    @Override
    protected void handle(Order order) {
        // 模拟通知逻辑
        System.out.println("📧 Sending confirmation for order #" + order.getOrderId());
        order.setStatus("Completed");
    }

    @Override
    protected boolean canHandle(Order order) {
        return order.isShipped(); // 只有发货完成才能发送通知
    }

    @Override
    protected String getHandlerName() {
        return "Notification";
    }
}

// 工厂类：创建处理器链
class HandlerChainFactory {
    private static final Map<String, OrderHandler> handlers = new HashMap<>();

    static {
        // 注册处理器类型
        handlers.put("validation", new ValidationHandler());
        handlers.put("payment", new PaymentHandler());
        handlers.put("shipping", new ShippingHandler());
        handlers.put("notification", new NotificationHandler());
    }

    // 创建标准处理器链
    public static OrderHandler createStandardChain() {
        OrderHandler validation = handlers.get("validation");
        OrderHandler payment = handlers.get("payment");
        OrderHandler shipping = handlers.get("shipping");
        OrderHandler notification = handlers.get("notification");

        validation.setNext(payment)
                 .setNext(shipping)
                 .setNext(notification);

        return validation;
    }

    // 创建自定义处理器链
    public static OrderHandler createCustomChain(String... handlerNames) {
        if (handlerNames == null || handlerNames.length == 0) {
            return null;
        }

        OrderHandler first = handlers.get(handlerNames[0]);
        OrderHandler current = first;

        for (int i = 1; i < handlerNames.length; i++) {
            OrderHandler next = handlers.get(handlerNames[i]);
            if (next != null) {
                current.setNext(next);
                current = next;
            }
        }

        return first;
    }
}

// 测试类
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("===== 标准订单处理流程 =====");
        Order standardOrder = new Order("ORD-1001", 150.0);
        OrderHandler standardChain = HandlerChainFactory.createStandardChain();
        standardChain.process(standardOrder);
        System.out.println("最终状态: " + standardOrder.getStatus());

        System.out.println("\n===== 自定义订单处理流程 =====");
        Order customOrder = new Order("ORD-2002", 75.0);
        // 只进行验证和通知的流程
        OrderHandler customChain = HandlerChainFactory.createCustomChain("validation", "notification");
        customChain.process(customOrder);
        System.out.println("最终状态: " + customOrder.getStatus());

        System.out.println("\n===== 订单状态变化过程 =====");
        System.out.println("标准订单: " + standardOrder);
        System.out.println("自定义订单: " + customOrder);
    }
}