#include "Channel.h"

ECMS::Channel::Channel(int id) {
	this->id = id;
}

void ECMS::Channel::initChannelUI(Fl_Group* group, Fl_Slider* slider, Fl_Dial* dial){
	this->channelGroup = group;
	this->volume = slider;
	this->pan = dial;

	this->volume->callback((Fl_Callback*)volumeSliderUpdate);
	
	channelGroup->add(volume);
	channelGroup->add(dial);
}

void ECMS::Channel::volumeSliderUpdate(Fl_Widget* o, void* v) {
	pan->value(((Fl_Slider*)o)->value());
}