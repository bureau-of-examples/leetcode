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


    public Trade(Chart chart, int buyDayIndex, double buyPrice, int volume) {
        this.chart = chart;
        this.buyDayIndex = buyDayIndex;
        this.buyPrice = buyPrice;
        this.volume = volume;
    }

    public void complete(int sellDayIndex, double sellPrice) {
        this.sellDayIndex = sellDayIndex;
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return String.format("Bought on %s and Sold on %s with profit %.2f",
                chart.getCandle(buyDayIndex).date,
                chart.getCandle(sellDayIndex).date,
                (sellPrice - buyPrice) / buyPrice);
    }
}
