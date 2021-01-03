package zhy2002.trading;

import lombok.Getter;

@Getter
public class Trade {

    private final Chart chart;
    private final int buyDayIndex;
    private final double buyPrice;
    private final int volume;

    private int sellDayIndex = -1;
    private double sellPrice = -1;
    private double minPrice;
    private double maxPrice;


    public Trade(Chart chart, int buyDayIndex, double buyPrice, int volume) {
        this.chart = chart;
        this.buyDayIndex = buyDayIndex;
        this.buyPrice = this.maxPrice = this.minPrice = buyPrice;
        this.volume = volume;
    }

    public void complete(int sellDayIndex, double sellPrice) {
        this.sellDayIndex = sellDayIndex;
        this.sellPrice = sellPrice;
    }

    public void updatePrice(double price) {
        if (price > maxPrice) {
            maxPrice = price;
        }
        if (price < minPrice) {
            minPrice = price;
        }
    }

    @Override
    public String toString() {
        return String.format("Bought on %s and Sold on %s with profit %.2f hold days %d",
                chart.getCandle(buyDayIndex).date,
                chart.getCandle(sellDayIndex).date,
                (sellPrice - buyPrice) / buyPrice,
                sellDayIndex - buyDayIndex);
    }

    public boolean isComplete() {
        return this.sellPrice != -1;
    }

    public double getDrawDown() {
        return (buyPrice - minPrice) / buyPrice;
    }
}
