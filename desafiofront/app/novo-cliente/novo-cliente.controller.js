(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('novoClienteController', novoClienteController);

    novoClienteController.$inject = ['helperFactory', 'clienteService'];

    function novoClienteController(helper, clienteService) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.init = init;
        vm.cliente = null;

        function init() {
            vm.listarClientes();
        }

        /* ***************    FUNÇÕES ADD 'VM' PARA TESTES     **************** */
        vm.listarClientes = listarClientes;
        vm.buscarCEP = buscarCEP;
        vm.criarUsuario = criarUsuario;

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */
        function listarClientes() {
            return clienteService.listar()
                .then(function (_listaClientes) {
                    vm.listaClientes = _listaClientes;
                });
        }

        function buscarCEP() {
            return clienteService.buscarCEP(vm.cliente.cep)
                .then(function (endereco) {
                    vm.cliente.bairro = endereco.bairro;
                    vm.cliente.complemento = endereco.complemento;
                    vm.cliente.cidade = endereco.localidade;
                    vm.cliente.logradouro = endereco.logradouro;
                    vm.cliente.uf = endereco.uf;
                });
        }

        function criarUsuario() {
            return clienteService.inserir(vm.cliente)
                .then(function (response) {
                    vm.go('/clientes')
                });
        }

    }

})();