#include "Channel.h"

ECMS::Channel::Channel(int id) {
	this->id = id;
}

void ECMS::Channel::initChannelUI(Fl_Group* group, Fl_Slider* slider){
	this->channelGroup = group;
	this->volume = slider;
}

