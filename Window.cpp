#include "Window.h"

UI::Window::Window(std::string name, int width, int height, ECMS::Mixer* mixer) : Fl_Window(width, height, name.c_str()) {
	// Setup UI

	// Mixer
	mixerGroup = new Fl_Group(0, height - MIXER_HEIGHT, width, MIXER_HEIGHT, "ECMS Mixer");
	mixerGroup->box(FL_GTK_DOWN_BOX);

	
	// Calculate the width of the browser
	int bGroupW = width / 5;
	browserGroup = new Fl_Group(0, 15, bGroupW, height - MIXER_HEIGHT, "Browser");
	browserGroup->box(_FL_GTK_DOWN_BOX);

	arrangmentGroup = new Fl_Group(bGroupW, 15, width - bGroupW, height - MIXER_HEIGHT, "Arrangment");
	arrangmentGroup->box(_FL_GTK_DOWN_BOX);
	

	// Calculate slider width
	int sliderWidth = (width - bGroupW) / mixer->getChannels().size();
	for (int i = 0; i < mixer->getChannels().size(); i++) {
		// Volume slider
		Fl_Group* channelGroup = new Fl_Group(i * sliderWidth + bGroupW, height - MIXER_HEIGHT, sliderWidth, height - MIXER_HEIGHT);
		ECMS::VolumeSlider* volSlider = new ECMS::VolumeSlider(i * sliderWidth + bGroupW, height - MIXER_HEIGHT, sliderWidth / 2, MIXER_HEIGHT, "Volume");
		// Setup volume slider
		volSlider->minimum(100.0);
		volSlider->maximum(0.00);
		volSlider->value(100.0);
		// Pan dial
		Fl_Dial* panDial = new Fl_Dial(i * sliderWidth + bGroupW + (sliderWidth / 2) + 1, height - MIXER_HEIGHT, sliderWidth / 4, sliderWidth / 4);
		channelGroup->box(FL_GTK_DOWN_BOX);
		// Init mixer
		mixer->getChannels()[i]->initChannelUI(channelGroup, volSlider, panDial);
		mixerGroup->add(channelGroup);
	}
	
	
	// Setup menu
	fileBar = new Fl_Menu_Bar(0, 0, width, 30, "ECMS");
	fileBar->add("&File/&Open",  "^o", menuCallBack);
	fileBar->add("&File/&Save",  "^s", menuCallBack, 0, FL_MENU_DIVIDER);
	fileBar->add("&File/&Quit",  "^q", menuCallBack);
	fileBar->add("&Edit/&Copy",  "^c", menuCallBack);
  	fileBar->add("&Edit/&Paste", "^v", menuCallBack, 0, FL_MENU_DIVIDER);
}


void UI::menuCallBack(Fl_Widget *w, void* v){

}