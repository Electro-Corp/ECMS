#include "Window.h"

UI::Window::Window(std::string name, int width, int height, ECMS::Mixer* mixer) : Fl_Window(width, height, name.c_str()) {

	// Setup UI
	mixerGroup = new Fl_Group(0, height - MIXER_HEIGHT, width, MIXER_HEIGHT, "ECMS Mixer");
	mixerGroup->box(FL_GTK_DOWN_BOX);

	// Calculate slider width
	int sliderWidth = width / mixer->getChannels().size();
	for(int i = 0; i < mixer->getChannels().size(); i++){
		// Volume slider
		Fl_Group* channelGroup = new Fl_Group()
		Fl_Slider* volSlider = new Fl_Slider(i * sliderWidth, height - MIXER_HEIGHT, sliderWidth, height - MIXER_HEIGHT);
		mixer->getChannels()[i]->setVolumeSlider(volSlider);
		mixerGroup->add(volSlider);
	}
	
	// Calculate the width of the browser
	int bGroupW = width / 5;
	browserGroup = new Fl_Group(0, 15, bGroupW, height - MIXER_HEIGHT, "Browser");
	browserGroup->box(_FL_GTK_DOWN_BOX);

	arrangmentGroup = new Fl_Group(bGroupW, 15, width - bGroupW, height - MIXER_HEIGHT, "Arrangment");
	arrangmentGroup->box(_FL_GTK_DOWN_BOX);

}