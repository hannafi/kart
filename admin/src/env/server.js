var express = require('express');
var path = require('path');

const port = process.env.PORT || 8081;
const dist = path.join(__dirname, 'dist');

var app = express();

app.set('view engine', 'html');
app.set('views', dist);

// Serve static files from dist
app.get('*.*', express.static(dist));

// Catch all other routes and return the index file
app.get('*', function (req, res) {
    res.sendFile(path.join(dist, 'index.html'));
});

app.listen(port, function(){
    console.log('Server listening on ', port);
});