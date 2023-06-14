package main.lld.consistenthashing.algorithms;

import main.lld.consistenthashing.models.Node;
import main.lld.consistenthashing.models.Request;

public interface Router {
    void addNode(Node node);

    void removeNode(Node node);

    Node getAssignedNode(Request request);
}