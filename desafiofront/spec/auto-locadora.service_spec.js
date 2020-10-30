describe('autoLocadoraService', function () {

    beforeEach(module('autoLocadoraApp'));

    describe('Testando Service', function () {
        var service, $httpBackend;

        var respSuccess = 'sucesso';

        beforeEach(inject(function ($injector) {
            service = $injector.get('autoLocadoraService');
            $httpBackend = $injector.get('$httpBackend');
        }));

        beforeEach(function () {
            $httpBackend.whenGET('home.tpl.html').respond(200, {});
        });

        // INIT
        // ENTRADA
        // SAÍDA
        // MÉT0DO TESTADO
        it(': deve estar DEFINIDA', function () {
            expect(service).toBeDefined();
        });

        describe(': requisição para listar()', function () {
            var urlReq = 'http://localhost:8080/api/carro';
            var req = {};
            var method = 'GET';
            it('deve dar sucesso', function () {
                // INIT
                $httpBackend.when(method, urlReq)
                    .respond(200, respSuccess);
                // MÉT0DO TESTADO
                service.listar(req)
                    .then(function (response) {
                        expect(response).toEqual('sucesso');
                    });
                $httpBackend.flush();
            });

            it('deve dar erro', function () {
                // INIT
                $httpBackend.when(method, urlReq)
                    .respond(400, {});
                // MÉT0DO TESTADO
                service.listar(req, 0);
                $httpBackend.flush();
            });
        });



    });
});
