(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .component('alertas', {
            templateUrl: 'componentes/alertas.tpl.html',
            controller: 'AlertasController',
            controllerAs: 'vm',
            bindings: {
                ctrl: '=',
                params: '<',
            },
        });

})();