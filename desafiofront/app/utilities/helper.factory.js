(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .factory('helperFactory', helperFactory);

    helperFactory.$inject = [
        '$rootScope',
        '$location',
        'constantes',
        'capitalizeFilter'
    ];

    function helperFactory($rootScope, $location, constantes, capitalize) {

        return {
            addAlerta: addAlerta,
            setRootScope: setRootScope,
            getRootScope: getRootScope,
            rootScopeApply: rootScopeApply,
            sendError: sendError,
            path: path,
            go: go,
        }

        function addAlerta(_msg, _tipo, _acao) {
            var lastMsg = $rootScope.alertas.length ?
                $rootScope.alertas[$rootScope.alertas.length - 1] : { text: '' };

            if (lastMsg.text !== _msg) {
                $rootScope.alertas.push({
                    text: _msg ? _msg : constantes.MSG_ERRO,
                    tipo: _tipo ? _tipo : 'info',
                    acao: _acao ? _acao : ''
                });
            }
        }

        function setRootScope(_key, _obj) {
            $rootScope[_key] = _obj;
        }

        function getRootScope(_key) {
            return $rootScope[_key];
        }

        function rootScopeApply() {
            $rootScope.$apply();
        }

        function sendError(_error) {
            return { error: true, msg: _error.data.message };
        }

        function path(_path) {
            $rootScope.alertas = [];
            return _path ? $location.path(_path) : $location.path();
        }

        function go(_path) {
            $rootScope.alertas = [];
            var path = _path ? _path : $location.path();
            $location.path(path);
            $rootScope.page = setPage();

            function setPage() {
                var page = $location.path().substring(1);
                if (page.indexOf('/') === -1) return page;
                var arr = page.split('/');
                return capitalize(arr[0]) + ' | ' + capitalize(arr[1]);
            }
        }

    }

})();