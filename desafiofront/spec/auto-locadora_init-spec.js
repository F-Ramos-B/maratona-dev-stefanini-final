(function () {

    angular.mock.autoLocadoraMockApp = function ($routeProvider) {
        module('autoLocadoraApp');
        module(function ($provide) {
            $provide.service('autoLocadoraService', function () {
                return {
                    exemplo: function () { return {}; },
                };
            });
        });
    };

}());
