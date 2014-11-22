var express = require('express');
var app = express();
var mongoose = require('mongoose');

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
app.post('/api/child/addItemToWishlist', function (req, res) {
	Child.find(function(err, tokens) {
				if(err)console.log(err);
				
				//res.send();
				console.log("FOUND CHILD OBJECT");
			  });
})

// Parent


app.get('/', function (req, res) {
	//res.send("Hello");
	Child.find(function(err, todos) {
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