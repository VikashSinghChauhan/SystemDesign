package Fee;

import Ticketing.Ticket;
import Vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private Map<VehicleType, Double> hourlyRates = new HashMap<>();
    {
        hourlyRates.put(VehicleType.CAR, 20.0);
        hourlyRates.put(VehicleType.BIKE, 10.0);
        hourlyRates.put(VehicleType.TRUCK, 30.0);
    }
    @Override
    public double calculateFee(Ticket ticket) {
      long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
      long hours = duration/(1000*60*60) + 1;
      return hours*hourlyRates.get(ticket.getVehicle().getType());
    }
}
