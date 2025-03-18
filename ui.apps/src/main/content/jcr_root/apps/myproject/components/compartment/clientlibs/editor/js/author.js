/* global jQuery, Coral */
(function($, Coral){
"use strict";
console. log("-------CLIENTLIBS LOADED-------");
var registry = $(window).adaptTo("foundation-registry");
// Validator for required for multifield max and min, items
registry.register("foundation.validation.validator", {
selector: "[data-validation=compartment-multifield]",
validate: function(element) {
var el = $(element);
let max = el.data("max-items");
let min = el.data("min-items");
let items=el.children("coral-multifield-item").length;
console.log("{} : {} : {} ", max,min,items);
if(items>max){
return "You can add only" +max+" compartment. You are trying to add " +items+"th compartment"
}
if(items<min){
return "You add " +min+ " compartment "
}
}
});
})(jQuery,Coral);