describe('HeaderController', function () {

    var $controller, $rootScope, $httpBackend, $location, service, helper;

    beforeEach(function () {
        angular.mock.autoLocadoraMockApp();
    });

    beforeEach(inject(function ($injector) {
        $controller = $injector.get('$controller');
        $rootScope = $injector.get('$rootScope');
        $httpBackend = $injector.get('$httpBackend');
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
            vm = $controller('HeaderController', { '$rootScope': $rootScope, '$scope': scope });

        });
        // ENTRADA
        // SAÍDA
        // INIT
        // MÉT0DO TESTADO
        it(': deve estar definido', function () {
            expect(vm).toBeDefined();
        });

        it(': deve iniciar executando "vm.go"', function () {
            // INIT
            // cria um 'spy' (espião, função mascarada que simula a função real)
            vm.go = jasmine.createSpy('go');
            // MÉT0DO TESTADO
            vm.iniciar();
            expect(vm.go).toHaveBeenCalled();
        });

    });
});
