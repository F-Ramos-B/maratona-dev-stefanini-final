(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('clienteController', clienteController);

    clienteController.$inject = ['helperFactory', 'clienteService'];

    function clienteController(helper, clienteService) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.init = init;
        vm.listaClientes = [];
        vm.historicos = [];

        function init() {
            vm.listarClientes();
        }

        /* ***************    FUNÇÕES ADD 'VM' PARA TESTES     **************** */
        vm.listarClientes = listarClientes;
        vm.listarHistorico = listarHistorico;

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */
        function listarClientes() {
            return clienteService.listar()
                .then(function (_listaClientes) {
                    console.log(_listaClientes);
                    vm.listaClientes = _listaClientes;
                });
        }

        function listarHistorico(id) {
            return clienteService.listarHistorico(id)
                .then(function (_historico) {
                    console.log(_historico);
                    vm.historicos = _historico;
                });
        }

    }

})();