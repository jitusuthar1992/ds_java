package main.design_pattern.behavioral.visitor;

public interface ItemElement {
    int accept(ShoppingCartVisitor shoppingCartVisitor);
}
