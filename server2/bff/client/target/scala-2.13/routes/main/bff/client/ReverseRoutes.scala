// @GENERATOR:play-routes-compiler
// @SOURCE:bff/client/conf/client.routes

import play.api.mvc.Call



// @LINE:2
package bff.client {

  // @LINE:2
  class ReverseDevisController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def getAllDevis(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "devis")
    }
  
  }


}
