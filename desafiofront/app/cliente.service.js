(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .service('clienteService', clienteService);

    clienteService.$inject = ['$http', 'constantes', 'helperFactory'];

    function clienteService($http, constantes, helper) {

        return {
            listar: _listar,
            inserir: _inserir,
            buscarCEP: _buscarCEP,
            alugar: _alugar,
            devolver: _devolver,
            listarHistorico: _listarHistorico
        }

        // ======================================

        function _listar() {
            return $http.get(constantes.URL_BASE + '/cliente')
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function _listarHistorico(id) {
            return $http.get(constantes.URL_BASE + '/historico/' + id)
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function _inserir(cliente) {
            return $http.post(constantes.URL_BASE + '/cliente', cliente)
                .then(function () {
                    return null;
                })
                .catch(helper.sendError);
        }

        function _alugar(id, placa) {
            return $http.put(constantes.URL_BASE + `/cliente/alugar/${id}/${placa}`)
                .then(function () {
                    return null;
                })
                .catch(helper.sendError);
        }

        function _devolver(id) {
            return $http.put(constantes.URL_BASE + `/cliente/devolver/${id}`)
                .then(function () {
                    return null;
                })
                .catch(helper.sendError);
        }

        function _buscarCEP(cep) {
            return $http.get(`${constantes.URL_VIACEP}/${cep}/json`)
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

    }


})();