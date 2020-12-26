package zhy2002.trading.strategy;

import lombok.Getter;
import zhy2002.trading.Candle;
import zhy2002.trading.indicator.MA;

import java.util.List;

@Getter
public class CrossMa {

    private final MA ma;

    private double fund; // cash fund amount left
    private int winCount;
    private int loseCount;
    private double price = -1; // the last buy price
    private int share; // number of shares holding

    public CrossMa(int maPeriods) {
        ma = new MA(maPeriods);
    }

    public void run(double startFund, List<Candle> candles, int startDayIndex) {
        ma.compute(candles);

        fund = startFund;
        for (int index = startDayIndex; index < candles.size(); index++) {
            Candle current = candles.get(index);
            Candle past1 = candles.get(index - 1);
            Candle past2 = candles.get(index - 2);

            if (share == 0) {
                // buy if current price below ma and share price rises 2 days in a row
                if (current.close < ma.get(index) &&
                        current.close > past1.close && past1.close > past2.close) {
                    price = current.close;
                    share = (int) (fund / price);
                    fund -= share * price;
                }
            } else {
                // sell if current price above ma and share price falls 2 days in a row
                if (current.close > ma.get(index) &&
                        current.close < past1.close && past1.close < past2.close) {
                    fund += share * current.close;
                    if (price < current.close) {
                        winCount++;
                    } else {
                        loseCount++;
                    }
                    price = -1;
                    share = 0;
                }
            }
        }
    }

    public double getLastFund() {
        return fund + price * share;
    }

    public int tradeCount() {
        return winCount + loseCount;
    }

    @Override
    public String toString() {
        return String.format("%s(%d) - Last fund: %2f, win count: %d, lose count: %d",
                this.getClass().getSimpleName(), this.getMa().getPeriods(), getLastFund(), winCount, loseCount);
    }
}
