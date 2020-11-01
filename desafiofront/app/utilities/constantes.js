(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .constant('constantes', {
            URL_BASE: 'http://localhost:8080/api',
            URL_VIACEP: 'https://viacep.com.br/ws',
            MSGS: {
                ERRO_GERAL: 'Ocorreu algum problema. Tente novamente mais tarde.',
            }
        });

})();