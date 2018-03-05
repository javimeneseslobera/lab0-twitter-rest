function registerSearch() {
    $("#search").submit(function(event){
        event.preventDefault();
        var target = $(this).attr('action');
        var query = $("#q").val();
        $.get(target, { q: query } )
            .done( function(data) {
                var tweetCard = $('#tweetCard').html();
				Mustache.parse(tweetCard);
				$("#resultsBlock").empty().html(Mustache.render(tweetCard, data));
            }).fail(function() {
            $("#resultsBlock").empty();
        });
    });
}

$(document).ready(function() {
	registerSearch();
});


