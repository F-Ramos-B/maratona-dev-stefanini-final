describe('HomeController', function () {

    var $controller, $rootScope, $httpBackend, service;

    beforeEach(function () {
        angular.mock.autoLocadoraMockApp();
    });

    beforeEach(inject(function ($injector) {
        $controller = $injector.get('$controller');
        $rootScope = $injector.get('$rootScope');
        $httpBackend = $injector.get('$httpBackend');
        service = $injector.get('autoLocadoraService');
    }));

    afterEach(function () {
        $httpBackend.flush();

        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    beforeEach(function () {
        $httpBackend.whenGET('home.tpl.html').respond(200, {});
    });

    describe('Testando Controller', function () {
        var vm, scope;

        beforeEach(function () {
            scope = $rootScope.$new();
            vm = $controller('HomeController', { '$rootScope': $rootScope, '$scope': scope });

        });
        // ENTRADA
        // SAÍDA
        // INIT
        // MÉT0DO TESTADO
        it(': deve estar definido', function () {
            expect(vm).toBeDefined();
        });

        it(': deve iniciar buscando lista de carros', function () {
            // INIT
            // cria um 'spy' (espião, função mascarada que simula a função real)
            vm.listarCarros = jasmine.createSpy('listarCarros');
            // MÉT0DO TESTADO
            vm.iniciar();
            expect(vm.listarCarros).toHaveBeenCalled();
        });

        it(': deve buscar lista de carros', function () {
            // INIT
            // garantir no inicio do teste que'vm.listaCarros' está vazia
            vm.listaCarros = [];
            // lista mock
            var val = [1, 2, 3];
            // cria uma promise mock (fake, falsa) e retorna lista mock
            var p = new Promise(function (resolve, reject) { resolve(val); })
            // cria um 'spy' (espião, função mascarada que simula a função real)
            // e retorna a promise mock
            service.listar = jasmine.createSpy('listar').and.returnValue(p);
            // MÉT0DO TESTADO
            return vm.listarCarros()
                .then(function () {
                    expect(vm.listaCarros.length).toBeGreaterThan(0);
                });
        });

    });
});
