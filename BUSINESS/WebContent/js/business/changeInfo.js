$(document).ready(function(){
     var bodyHtml = $("body");
    if ($("#changeInfo").innerHTML == undefined) {
        var resultModelHTml = "";
        resultModelHTml += '<div id="myModal" class="row modal fade bs-example-modal-sm" tabindex="-1" role="dialog"';
        resultModelHTml += '     aria-labelledby="mySmallModalLabel">';
        resultModelHTml += '    <div class="modal-dialog modal-lg">';
        resultModelHTml += '        <div id="result-content" class="modal-content">';
        resultModelHTml += '            <div class="modal-header">';
        resultModelHTml += '                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span';
        resultModelHTml += '                        aria-hidden="true">&times;</span></button>';
        resultModelHTml += '                <h4 class="modal-title">Modal title</h4>';
        resultModelHTml += '            </div>';
        resultModelHTml += '            <div id="result-body" class="modal-body container-fluid">';
		resultModelHTml += '			';
        resultModelHTml += '            </div>';
        resultModelHTml += '            <div class="modal-footer">';
        resultModelHTml += ' <button onclick="location=\'https://www.alipay.com/\'" type="button" class="btn btn-success">go to pay';
        resultModelHTml += '</button>';
        resultModelHTml += '                <button type="button" class="btn btn-primary" data-dismiss="modal">continue</button>';
        resultModelHTml += '            </div>';
        resultModelHTml += '        </div>';
        resultModelHTml += '    </div>';
        resultModelHTml += '</div>';
        $(bodyHtml).prepend(resultModelHTml);
//        bindShoppingChart();
    } else {
//        bindShoppingChart();
    }
});