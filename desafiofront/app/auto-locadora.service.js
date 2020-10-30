(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .service('autoLocadoraService', autoLocadoraService);

    autoLocadoraService.$inject = ['$http', 'constantes', 'helperFactory'];

    function autoLocadoraService($http, constantes, helper) {

        return {
            listar: listar
        }

        // ======================================

        function listar() {
            return $http.get(constantes.URL_BASE + '/carro')
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

    }


})();