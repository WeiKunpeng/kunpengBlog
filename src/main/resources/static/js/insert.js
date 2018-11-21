$(function () {
    function initToolbarBootstrapBindings() {
        var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
        $.each(fonts, function (idx, fontName) {
            fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
        });
        $('a[title]').tooltip({container: 'body'});
        $('.dropdown-menu input').click(function () {
            return false;
        }).change(function () {
            $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
        }).keydown('esc', function () {
            this.value = '';
            $(this).change();
        });

        $('[data-role=magic-overlay]').each(function () {
            var overlay = $(this), target = $(overlay.data('target'));
            overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
        });
        $('#voiceBtn').hide();

    };
    initToolbarBootstrapBindings();
    $('#editor').wysiwyg();
    window.prettyPrint;


    $('#bt1').click(function (e) {
        e.preventDefault();


        //alert("1111");


        var uid="";


        var title=$('#title').val();

        var desc=$('#desc').val();

        var content=$('#editor').html();



        window.console(content);


        var article={"cid":"","uid":uid,"type":"","title":title,"desc":desc,"content":content,url:"",tags:"",hits:0,stars:0,create_time:null,update_time:null};



        var date=new Array();
        date[0]=title;
        date[1]=desc;
        date[2]=content;
        var url="/article/preview";



        httpPost(url,article);

        function httpPost(URL, PARAMS) {
            var temp = document.createElement("form");
            temp.action = URL;
            temp.target = "_blank";
            temp.method = "post";
            temp.style.display = "none";

            for (var x in PARAMS) {
                var opt = document.createElement("textarea");
                opt.name = x;
                opt.value = PARAMS[x];
                temp.appendChild(opt);
            }

            document.body.appendChild(temp);
            temp.submit();

            return temp;
        }




        //submit();



        //alert(title);
        //alert(desc);
        //
        //alert(content);






        //function submit() {
        //
        //    $.ajax({
        //        url: '/article/preview',
        //        type: 'post',
        //        data: article,
        //        dataType: 'text',
        //        success: function (ret) {
        //
        //
        //            alert(ret)
        //
        //        },
        //        fail: function (ret) {
        //            alert("error")
        //        }
        //    }).done(function () {
        //        self.removeClass('disabled');
        //    });
        //}

        return false;
    });
});