$(document).ready(function () {
    console.log("I am ready!!!!");
    $(".onlyNumberClass").keypress(function (evt) {
        console.log("ke press!!!!");
        if ((evt.which > 47 && evt.which < 58) || evt.which == 44 || evt.which ==8 || evt.which ==46 ) {

        }
        else
            evt.preventDefault();

    })
});
