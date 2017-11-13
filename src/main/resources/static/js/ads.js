"use strict";

(function($){
    $.ajax({'url': '/ads.json'})
        .done(function(data){
            var html = '';
            data.forEach(function(ad) {
                html += '<div>';
                html += '<h1>' + ad.title + '</h1>';
                html += '<p>' + ad.description + '</p>';
                html += '<p>Published by ' + ad.user.username + '</p>';
                html += '</div>';
            });
            // replaces the content of the ads id element
            $('#ads').html(html);
        })
})(jQuery);



