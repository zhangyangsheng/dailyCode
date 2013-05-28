/***
 * Excerpted from "Programming Concurrency on the JVM",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vspcon for more book information.
***/
package com.agiledeveloper.pcj;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class YahooFinance {
  public static double getPrice(final String ticker) throws IOException {
    final URL url = 
      new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
    
    final BufferedReader reader = new BufferedReader(
      new InputStreamReader(url.openStream()));
    
    //Date,Open,High,Low,Close,Volume,Adj Close
    //2011-03-17,336.83,339.61,330.66,334.64,23519400,334.64    
    final String discardHeader = reader.readLine();
    final String data = reader.readLine();
    final String[] dataItems = data.split(",");
    final double priceIsTheLastValue = 
      Double.valueOf(dataItems[dataItems.length - 1]);
    return priceIsTheLastValue;
  }
}
