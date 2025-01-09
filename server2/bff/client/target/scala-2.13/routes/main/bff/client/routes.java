// @GENERATOR:play-routes-compiler
// @SOURCE:bff/client/conf/client.routes

package bff.client;

import client.RoutesPrefix;

public class routes {
  
  public static final bff.client.ReverseDevisController DevisController = new bff.client.ReverseDevisController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final bff.client.javascript.ReverseDevisController DevisController = new bff.client.javascript.ReverseDevisController(RoutesPrefix.byNamePrefix());
  }

}
