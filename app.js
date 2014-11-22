var express = require('express');
var app = express();
var mongoose = require('mongoose');

app.use(express.static(__dirname + '/public'));
app.use( express.static( "public" ) );

mongoose.connect('mongodb://dloza@ucsd.edu:Earnit@proximus.modulusmongo.net:27017/X6yvoheh'); //establishing connection to the MongoDB Database currently running on ucsd server

// models ===============================================

var Chore = mongoose.model('Chore', {
	name: String,
	value: Number
});

var Child = mongoose.model('Child', {
	username: String,
	wishlist: {
		itemName: String,
		price: Number
	}, 
	chores: [
		{
			name: String,
			value: Number,
			status: String
		}
	], 
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
	console.log("NO CALL");
})

var server = app.listen(3000, function () {

  var host = server.address().address
  var port = server.address().port

  console.log('Example app listening at http://%s:%s', host, port)

})