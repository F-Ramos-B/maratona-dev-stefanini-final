(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('HeaderController', headerController);

    headerController.$inject = ['helperFactory'];

    function headerController(helper) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.iniciar = iniciar;

        function iniciar() {
            vm.go();
        }

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */


    }

})();