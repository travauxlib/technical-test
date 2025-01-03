// @GENERATOR:play-routes-compiler
// @SOURCE:bff/client/conf/client.routes

import play.api.routing.JavaScriptReverseRoute



// @LINE:2
package bff.client.javascript {

  // @LINE:2
  class ReverseDevisController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def getAllDevis: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "bff.client.DevisController.getAllDevis",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "devis"})
        }
      """
    )
  
  }


}
