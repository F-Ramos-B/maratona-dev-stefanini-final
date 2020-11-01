(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('HomeController', homeController);

    homeController.$inject = ['helperFactory', 'autoLocadoraService', 'clienteService'];

    function homeController(helper, service, clienteService) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.iniciar = iniciar;
        vm.clienteSelecionado = null;

        function iniciar() {
            vm.listarClientes();
            vm.listarCarros();
        }

        /* ***************    FUNÇÕES ADD 'VM' PARA TESTES     **************** */
        vm.listarCarros = listarCarros;
        vm.listarClientes = listarClientes;
        vm.alugar = alugar;
        vm.devolver = devolver;

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */
        function listarCarros() {
            return service.listar()
                .then(function (_listaCarros) {
                    vm.listaCarros = _listaCarros;
                });
        }

        function alugar(placa) {
            return clienteService.alugar(vm.clienteSelecionado.id, placa)
                .then(function () {
                    vm.iniciar();
                });
        }

        function devolver() {
            return clienteService.devolver(vm.clienteSelecionado.id)
                .then(function () {
                    vm.iniciar();
                });
        }

        function listarClientes() {
            return clienteService.listar()
                .then(function (_listaClientes) {
                    vm.listaClientes = _listaClientes;
                    vm.clienteSelecionado = vm.listaClientes[0];
                });
        }

    }

})();