(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .filter('capitalize', function () {
            return function (input) {
                return (angular.isString(input) && input.length > 0) ?
                    input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : input;
            }
        })
        .filter('placaComHifen', function () {
            return function (input) {
                return (angular.isString(input) && input.length > 0) ?
                    input.substr(0, 3).toUpperCase() + '-' + input.substr(3) : input;
            }
        });

})();