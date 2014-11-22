var express = require('express');
var app = express();
var mongoose = require('mongoose');
var bodyParser = require('body-parser');    // pull information from HTML POST (express4)
app.use(bodyParser.urlencoded({'extended':'true'}));            // parse application/x-www-form-urlencoded
app.use(bodyParser.json());                                     // parse applicaetion/json
app.use(bodyParser.json({ type: 'application/vnd.api+json' })); // parse application/vnd.api+json as json

app.use(express.static(__dirname + '/public'));
app.use( express.static( "public" ) );

mongoose.connect('mongodb://137.110.91.32:27017'); //establishing connection to the MongoDB Database currently running on ucsd server

// models ===============================================

var Chore = mongoose.model('Chore', {
	name: String,
	value: Number
});

var Child = mongoose.model('Child', {
	username: String,
	wishList: {
			itemName: String,
			price: Number
		},
	chores: [
		{
			name: String,
			value: Number,
			status: String
		}
	]
});

var Parent = mongoose.model('Parent', { 
	username: String,
	childId: mongoose.Schema.Types.ObjectId
		
});

// routes ===============================================

// Child
app.post('/api/child/addItem', function (req, res) {
	console.log(req.body);

	Child.where({ "username": "Bobby" }).update({"wishList": req.body}, function(err, todos) {
		if (err)
			res.send(err)
		res.send(200);
	});
})

// Parent


app.get('/', function (req, res) {
	Child.find({"username": "Bobby"},function(err, todos) {
		if (err)
			res.send(err)
		res.json(todos);
	});

	console.log("NO CALL");
})

var server = app.listen(3000, function () {

  var host = server.address().address
  var port = server.address().port

  console.log('Example app listening at http://%s:%s', host, port)

})