APP.LinkView = Backbone.View.extend({
  // the wrapper defaults to div, so only need to set this if you want something else
  // like in this case we are in a table so a tr
  tagName: "tr",
  // functions to fire on events
  events: {
    "click a.delete": "destroy"
  },

  // the constructor
  initialize: function (options) {
    // model is passed through
    this.link  = options.link;
    this.links = options.links;
  },

  // populate the html to the dom
  render: function () {
    var j = this.link.toJSON();
    return this.$el.html(_.template($('#rowTemplate').html(), j)(j));
  },

  // delete the model
  destroy: function (event) {
    event.preventDefault();
    event.stopPropagation();
    // we would call
    // this.model.destroy();
    // which would make a DELETE call to the server with the id of the item
    this.links.remove(this.link);
    this.$el.remove();
  }
});
