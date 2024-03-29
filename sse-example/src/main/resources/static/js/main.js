function loadComments () {

    this.source = null;

    this.start = function () {

        var commentTable = document.getElementById("comments");

        this.source = new EventSource("/anuncios/stream");

        this.source.addEventListener("nuevo-anuncio", function (event) {

            // These events are JSON, so parsing and DOM fiddling are needed
            console.log(event);
            var anuncios = JSON.parse(event.data);
            anuncios.forEach(function(anuncio){
                var row = commentTable.getElementsByTagName("tbody")[0].insertRow(-1);
                var cell0 = row.insertCell(0);
                var cell1 = row.insertCell(1);
                var cell2 = row.insertCell(2);

                cell0.className = "author-style";
                cell0.innerHTML = anuncio.autor;

                cell1.className = "text";
                cell1.innerHTML = anuncio.anuncio;

                cell2.className = "date";
                cell2.innerHTML = anuncio.hora;
            });

        });

        this.source.onerror = function () {
            this.close();
        };

    };

    this.stop = function() {
        this.source.close();
    }

}

comment = new loadComments();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */
window.onload = function() {
    comment.start();
};
window.onbeforeunload = function() {
    comment.stop();
}