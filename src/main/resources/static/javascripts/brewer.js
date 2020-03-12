$(function() {
    const decimal = $('.js-decimal');
    decimal.maskMoney();

    const integer = $('.js-integer');
    integer.maskMoney({precision: 0});
});
