#include "Mixer.h"

ECMS::Mixer::Mixer(int channels) {

	// Create all channels
	// 0 is master
	for (int i = 0; i < channels; i++) {
		this->channels.push_back(Channel(i));
	}
}