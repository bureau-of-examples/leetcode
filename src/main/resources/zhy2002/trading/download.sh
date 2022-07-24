#!/usr/bin/env bash
set -e

TICKS=("REA.AX" "RIO.AX" "RMD.AX" "ALL.AX" "CSL.AX")

# Sunday, 1 January 2006 - back testing starts 1 January 2007
START_TIMESTAMP=1136073600
NOW_EPOCH=$(date +'%s')
END_TIMESTAMP=$((NOW_EPOCH / 86400 * 86400))
CSV_DIR="$(dirname "${BASH_SOURCE[0]}")/csv"

for TICK in "${TICKS[@]}"; do
  URL="https://query1.finance.yahoo.com/v7/finance/download/$TICK?period1=$START_TIMESTAMP&period2=$END_TIMESTAMP&interval=1d&events=history&includeAdjustedClose=true"
  echo "Downloading $TICK"
  curl "$URL" --output "$CSV_DIR/${TICK}.csv"
  # avoid getting blacklisted
  sleep $((5 + RANDOM % 5))
done

echo "Done!"