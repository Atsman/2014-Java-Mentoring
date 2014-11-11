APP.LinkEditView = Backbone.View.extend({
  // functions to fire on events
  events: {
    "click button.save": "save"
  },

  // the constructor
  initialize: function (options) {
    this.link  = options.link;
  },

  save: function (event) {
    // this keeps the form from submitting
    event.stopPropagation();
    event.preventDefault();

    // update our model with values from the form
    this.link.set({
      title: this.$el.find('input[name=title]').val(),
      href: this.$el.find('input[name=href]').val(),
      target: this.$el.find('input[name=target]').val()
    });
    // we would save to the server here with
    // this.note.save();
    // redirect back to the index
    window.location.hash = "link/index";
  },

  // populate the html to the dom
  render: function () {
    var j = this.link.toJSON();
    return this.$el.html(_.template($('#formTemplate').html(), j)(j));
  }
});
