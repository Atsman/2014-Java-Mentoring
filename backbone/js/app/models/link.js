APP.LinkModel = Backbone.Model.extend({
	defaults: {
		title: "",
		href: "",
		target: ""
	},

	validate: function (attrs) {
		var errors = {};
		if (!attrs.title) errors.text = "Title is blank.";
		if (!attrs.href) errors.description = "Href is blank";
		if (!attrs.target) errors.target = "Target is blank";
		if (!_.isEmpty(errors)) {
			return errors;
		}
	}
});

APP.LinkCollection = Backbone.Collection.extend({
	model: APP.LinkModel
});