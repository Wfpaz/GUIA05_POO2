$(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        unbind('check.bs.table').on('check.bs.table', function (e, row) {
            consTipo([{name : 'id', value : row.id.trim()}]);
        });
        return false;
    };
    
    $('#modaFormTipo').on('show.bs.modal', function() {
        INIT_OBJE_MODA_TIPO();
    });
    
    INIT_OBJE_TIPO();
});

function INIT_OBJE_TIPO()
{
    $("#tablTipo").initBootTable();
}

function INIT_OBJE_MODA_TIPO()
{
    $("#formTest\\:btonElim").confirmation({container: '#formTest'});
}