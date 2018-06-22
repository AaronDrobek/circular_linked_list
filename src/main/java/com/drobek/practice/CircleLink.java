package com.drobek.practice;

public class CircleLink {


    private Node firstNode;

    public void addNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (firstNode == null) {
            firstNode = newNode;
            firstNode.setNext(firstNode);
            firstNode.setFirst(true);
//            System.out.println(firstNode.getValue() + " firstnode the first time " + firstNode.getNext().getValue() + " the value of its get next" + " the boolean value " + firstNode.isFirst());
        } else {
            Node current = firstNode;
            if (current.getNext() == current) {
                current.setNext(newNode);
                current.getNext().setNext(current);
//                System.out.println(current.getValue() + " " + current.getNext().getValue() + " " + current.getNext().getNext().getValue() + " current value, get next value, getnext getnext value *** " + current.getNext().isFirst() + " " + current.getNext().getNext().isFirst());
            }


            do {
                current = current.getNext();

            } while (current.getNext().isFirst() == false);

            current.setNext(newNode);
//            System.out.println(current.getValue() + " this is current after else");
//            System.out.println(current.getNext().getValue() + " this is current getnext");
//
//            System.out.println(newNode.getValue() + " this is value of newNode");

            newNode.setNext(firstNode);

//            System.out.println(newNode.getNext().getValue() + " new node pointing back at firstnode");
        }
    }

    public void print() {
        if (firstNode != null) {
            System.out.print("List: " + firstNode.getValue());
            Node current = firstNode;
            //do iterate through until the flag is true and print all of them
            do {
                if (current.getNext() == current) {
                    continue;
                } else {
                    current = current.getNext();

                    System.out.print("," + current.getValue());
                }
            } while (current.getNext().isFirst() == false);
        } else {
            System.out.println("Empty list");
        }

    }

    public void removeLast() {
        if (firstNode != null) {
            //more then one node
            if (firstNode.getNext() == firstNode) {
                //when first node is the only node, this is the one to BE removed!
                firstNode = null;
                System.out.println("removed first node in case there was only one node");
            } else {
                Node current = firstNode;
                while (true) {
                    if (current.getNext().getNext().isFirst() == true) {
                        current.setNext(firstNode);
                        return;
                    }

                    current = current.getNext();
                }
            }
        } else {
            System.out.println("Nothing to remove !");
        }
    }
}
