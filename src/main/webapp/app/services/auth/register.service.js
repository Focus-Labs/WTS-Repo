(function () {
    'use strict';

    angular
        .module('weTravelSouthApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
