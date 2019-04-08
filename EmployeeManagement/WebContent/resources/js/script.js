    $('input[type="file"]').change(function(e){
        var fileName = e.target.files[0].name;
        console.log(fileName);
        var size = e.target.files[0].size;
        console.log(size);
        $('.custom-file-label').html(fileName);
    });
