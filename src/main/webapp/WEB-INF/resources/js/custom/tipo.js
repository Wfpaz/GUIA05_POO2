/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        $(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        unbind('check.bs.table').on('check.bs.table', function (e, row) {
            //consTipo([{name : 'codiAlumPara', value : row.id.trim()}]);
        });
        return false;
    };
    INIT_OBJE_TIPO();
});

function INIT_OBJE_TIPO()
{
    $("#tablTipo").initBootTable();
}