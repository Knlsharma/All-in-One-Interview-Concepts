package DesignPattern.BehaviouralDesign.ChainOfResponsibilityPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/04/23, Sunday
 **/
    public abstract class IHandler {
        protected IHandler next;

        public IHandler(IHandler next) {
            this.next = next;
        }

        abstract void handleRequest(Request obj);

        public IHandler getNext() {
            return next;
        }
    }
