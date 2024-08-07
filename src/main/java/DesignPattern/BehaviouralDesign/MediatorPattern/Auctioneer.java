//package DesignPattern.MomentoPattern;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author : Kunal Sharma
// * @since : 16/07/24, Tuesday
// **/
//public class Auctioneer implements AuctionMediator {
//    private List<Bidder> bidders;
//
//    public Auctioneer() {
//        this.bidders = new ArrayList<>();
//    }
//
//    @Override
//    public void addBidder(Bidder bidder) {
//        bidders.add(bidder);
//        bidder.setMediator(this);
//    }
//
//    @Override
//    public void bid(int amount, Bidder bidder) {
//        System.out.println(bidder.getName() + " bids " + amount);
//        // Logic to handle bidding process, notify other bidders, etc.
//        for (Bidder b : bidders) {
//            if (b != bidder) {
//                b.bid(amount); // Notify other bidders
//            }
//        }
//    }
//
//    @Override
//    public void cancelBid(Bidder bidder) {
//        System.out.println(bidder.getName() + " cancels their bid");
//        // Logic to cancel bidder's bid, notify other bidders, etc.
//        for (Bidder b : bidders) {
//            if (b != bidder) {
//                b.cancelBid(); // Notify other bidders
//            }
//        }
//    }
//}