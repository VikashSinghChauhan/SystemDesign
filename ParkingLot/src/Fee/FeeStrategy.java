package Fee;

import Ticketing.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
